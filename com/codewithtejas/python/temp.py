# my practice

from sys import getsizeof
from pprint import pprint

# # list comprehension
# list_values = [i*2 for i in range(500000)]
# print("list: ", getsizeof(list_values))

# # dict comprehension
# dict_values = {i: i*2 for i in range(500000)}
# print("dict: ", getsizeof(dict_values))

# # generator object
# gen_values = (i*2 for i in range(500000))
# print("gen:", getsizeof(gen_values))

sentence = "this is a common interview question"
char_frequency = {}
for char in sentence:
    if char in char_frequency:
        char_frequency[char] += 1
    else:
        char_frequency[char] = 1

sorted_output = sorted(
    char_frequency.items(),
    key=lambda kv: kv[1],
    reverse=True
)

print(sorted_output[0])

# items = [
#     ("prod1", 10),
#     ("prod2", 20),
#     ("prod3", 30),
# ]

# prices = list(map(lambda item: item[1], items))
# print(prices)

# products = list(map(lambda item: item[0], items))
# print(products)

# filtered = list(filter(lambda item: item[1] >= 12, items))
# print(filtered)

# using list comprehensions
# prices = [item[1] for item in items]
# print(prices)

# filtered = [item for item in items if item[1] >= 12]
# print(filtered)
