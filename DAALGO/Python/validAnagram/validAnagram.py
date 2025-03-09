class Solution:
    def isAnagram(s: str, t: str) -> bool:
        if len(s) != len(t):
            return False

        mapS, mapT = {}, {}

        for i in range(len(t)):
            mapS[s[i]] = 1 + mapS.get(s[i], 0)
            mapT[t[i]] = 1 + mapT.get(t[i], 0)

        for char in mapS:
            if mapS.get(char) != mapT.get(char, 0):
                return False
        return True


if __name__ == '__main__':
    print(Solution.isAnagram("bbcc", "ccbc"))