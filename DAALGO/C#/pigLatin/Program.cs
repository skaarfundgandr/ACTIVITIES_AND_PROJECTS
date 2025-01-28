// See https://aka.ms/new-console-template for more information
namespace pigLatin {
    class Program {
        static void Main(string[] args) {
            Console.WriteLine("Enter text to translate:");

            Console.WriteLine($"Piglatin: {pigLatin(Console.ReadLine())}");
        }
        public static string pigLatin(string src) {
            char firstLetter = '\0';
            string res = "";

            for (int idx = 0; idx < src.Length; idx++) {
                if (idx == 0) {
                    firstLetter = char.ToLower(src[idx]);
                } else {
                    if (src[idx - 1] == ' ' && src[idx] != ' ') {
                        firstLetter = char.ToLower(src[idx]);
                    } else if (src[idx - 1] == ' ' && src[idx] == ' ') {
                        continue;
                    } else if (src[idx] == ' ' || idx == src.Length - 1) {
                        res += firstLetter + "ay ";
                    } else {
                        res += src[idx];
                    }
                }
            }
            return res;
        }
    }
}