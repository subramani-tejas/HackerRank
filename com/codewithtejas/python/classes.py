# pylint: disable=missing-function-docstring
# pylint: disable=missing-module-docstring
# pylint: disable=missing-class-docstring
# pylint: disable=too-few-public-methods
# pylint: disable=unused-import - W0611

import cgi
from http import cookies
print('Content-Type:text/html')

cookie1 = cookies.SimpleCookie()
cookie1['name'] = 'tejas'
cookie1['id'] = '123'
print(cookie1.output())


# class TagCloud:
#     def __init__(self):
#         self.tags = {}

#     def add(self, tag):
#         self.tags[tag.lower()] = self.tags.get(tag.lower(), 0) + 1


# cloud = TagCloud()
# cloud.add("py")
# cloud.add("py")
# cloud.add("pY")

# print(cloud.tags)
