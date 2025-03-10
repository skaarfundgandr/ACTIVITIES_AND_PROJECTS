#include <arpa/inet.h>
#include <sys/socket.h>
#include <stdlib.h>
#include <stdio.h>
#include <netdb.h>
#include <netinet/in.h>
#include <stdio.h>
#include <string.h>
#include <sys/socket.h>
#include <unistd.h>

#define PORT "3990"

int main(int argc, char const **argv) {
    char usr_ip[INET_ADDRSTRLEN];

    struct addrinfo *res, *iter, hints;
    struct sockaddr_in *sa;
    struct sockaddr_storage usr_addr;
    socklen_t addrSize;
    int socketfd, addinfo, usr_fd, allow = 1;
    // Set hints to zeroes (will be used to configure the address information)
    memset(&hints, 0, sizeof hints);
    hints.ai_family = AF_INET; // Use IPv4
    hints.ai_socktype = SOCK_STREAM; // Use TCP packets
    hints.ai_flags = AI_PASSIVE; // Auto fill the address
    // Get network address information
    if (((addinfo = getaddrinfo(NULL, PORT, &hints, &res))) != 0) {
        fprintf(stderr, "%s\n", gai_strerror(addinfo));
        exit(1);
    }
    // Iterate through the addresses and create connection sockets
    for (iter = res; iter != NULL; iter = iter->ai_next) {
        // Create a socket on address
        if ((socketfd = socket(iter->ai_family, iter->ai_socktype, iter->ai_protocol)) == -1) {
            fprintf(stderr, "socket error\n");
            continue;
        }
        // Set socket options
        if ((setsockopt(socketfd, SOL_SOCKET, SO_REUSEADDR, &allow, sizeof(int))) == -1) {
            fprintf(stderr, "setsockopt error\n");
            exit(1);
        }
        // Bind the socket
        if ((bind(socketfd, iter->ai_addr, iter->ai_addrlen))) {
            close(socketfd);
            fprintf(stderr, "bind error\n");
            continue;
        }

        break;
    }
    // Done processing the address.
    freeaddrinfo(res); // Deallocates the address
    // If no sockets are bound
    if (!iter) {
        fprintf(stderr, "Failed to bind an address\n");
        exit(1);
    }
    // Listen on the bound socket
    if (listen(socketfd, 5) == -1) {
        fprintf(stderr, "Failed to listen on address");
        exit(1);
    }
    // Connection handling code
    while (1) {
        addrSize = sizeof usr_addr;
        // Accept connections (if there are any)
        usr_fd = accept(socketfd, (struct sockaddr *) &usr_addr, &addrSize);
        inet_ntop(usr_addr.ss_family, &(((struct sockaddr_in *) &usr_addr)->sin_addr), usr_ip, sizeof usr_ip);

        printf("%s connected to server\n", usr_ip);
        // Spawn a different process to handle the user's connection
        if (!fork()) {
            close(socketfd); // Deallocate server socket. This is not needed for sending data to the client
            char *mssg = "Test HTTP Server\n";
            int bytesSent = send(usr_fd, mssg, strlen(mssg), 0); // Send the message to the client
            // Error handling if sending the data has failed
            if (bytesSent == -1) {
                fprintf(stderr, "Error sending packet\n");
            } else {
                printf("%d bytes sent to %s\n", bytesSent, usr_ip);
            }

            close(usr_fd); // Finally, close the user socket
            exit(0); // Exit success
        }
        // User socket is not needed on server this is already handled by a different process
        close(usr_fd);
    }
}