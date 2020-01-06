#! /usr/bin/python3
# -*- coding=UTF-8 -*-

# 合法的括号


def isValid(s: str) -> bool:
    stack = []
    paren_map = {')': '(', '}': '{', ']': '['}
    for c in s:
        if c not in paren_map:
            stack.append(c)
        elif not stack or paren_map[c] != stack.pop():
            return False
    return not stack

s = '({[()]})'
print("str -> %s" % s)
valid = isValid(s)
print(valid)
s = '([()]})'
print("str -> %s" % s)
valid = isValid(s)
print(valid)

