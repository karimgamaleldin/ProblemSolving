class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        count = n
        bed_len = len(flowerbed)
        for i, pot in enumerate(flowerbed):
            if pot == 1:
                continue
            elif i == bed_len - 1 and flowerbed[i - 1] == 0:
                count -= 1
            elif i == 0 and flowerbed[i + 1] == 0:
                count -= 1
                flowerbed[i] = 1
            elif flowerbed[i - 1] == 0 and flowerbed[i + 1] == 0:
                count -= 1
                flowerbed[i] = 1
        return count <= 0