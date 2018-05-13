#!/usr/bin/python2.4 -tt
# Copyright 2010 Google Inc.
# Licensed under the Apache License, Version 2.0
# http://www.apache.org/licenses/LICENSE-2.0

# Google's Python Class
# http://code.google.com/edu/languages/google-python-class/

# Additional basic string exercises

import re

# D. verbing
# Given a string, if its length is at least 3,
# add 'ing' to its end.
# Unless it already ends in 'ing', in which case
# add 'ly' instead.
# If the string length is less than 3, leave it unchanged.
# Return the resulting string.
def verbing(s):
  # +++your code here+++
  if len(s) >= 3:
    if s[-3:] != 'ing':
      strvar = s + 'ing'
    else: 
      strvar = s + 'ly'
  else:
    strvar = s;
  return strvar


# E. not_bad
# Given a string, find the first appearance of the
# substring 'not' and 'bad'. If the 'bad' follows
# the 'not', replace the whole 'not'...'bad' substring
# with 'good'.
# Return the resulting string.
# So 'This dinner is not that bad!' yields:
# This dinner is good!
def not_bad(s):
  # +++your code here+++
  ##strvar = re.sub(r'not.*bad', 'good', s) -- using re is super-easy
  # not_index = s.find('not');
  # if not_index != -1:
  #   bad_index = s.find('bad',not_index)
  #   if bad_index != -1:
  str_list = s.split()
  strlen  = len(str_list)
  match = 0;
  for i in range (0, strlen):
    if str_list[i] == 'not':
      for j in range(i+1, strlen):
        if str_list[j].isalpha() != 1:
          for k in range (0, len(str_list[j])):
            if str_list[j][k].isalpha() != 1:
              str_list.append(str_list[j][k]);
              str_list[j] = str_list[j][:k] + str_list[j][k+1:]
        if str_list[j] == 'bad': 
          match = 1;
          start_index = i;
          end_index = j;
          break;

  if match == 1:
    str_list = str_list[:start_index] + ['good'] + str_list[end_index+1:]
    for i in range (0, len(str_list)):
      if i == 0:
        strvar = str_list[i]
      elif str_list[i].isalpha() == 1:
        strvar += ' ' + str_list[i]
      else:
        strvar += str_list[i]
  else:
   strvar = s
  return strvar


# F. front_back
# Consider dividing a string into two halves.
# If the length is even, the front and back halves are the same length.
# If the length is odd, we'll say that the extra char goes in the front half.
# e.g. 'abcde', the front half is 'abc', the back half 'de'.
# Given 2 strings, a and b, return a string of the form
#  a-front + b-front + a-back + b-back
def front_back(a, b):
  # +++your code here+++
  a_list = front_back_single(a)
  b_list = front_back_single(b)
  strvar = a_list[0] + b_list[0] + a_list[1] + b_list[1]
  return strvar

def front_back_single(a):
  half_len_a = len(a) // 2;
  if len(a) % 2 == 0:
    a_front = a[:half_len_a]
    a_back = a[half_len_a:]
  else:
    a_front = a[:half_len_a+1]
    a_back = a[half_len_a+1:]
  return [a_front, a_back]     

# Simple provided test() function used in main() to print
# what each function returns vs. what it's supposed to return.
def test(got, expected):
  if got == expected:
    prefix = ' OK '
  else:
    prefix = '  X '
  print('%s got: %s expected: %s' % (prefix, repr(got), repr(expected)))


# main() calls the above functions with interesting inputs,
# using the above test() to check if the result is correct or not.
def main():
  print('verbing')
  test(verbing('hail'), 'hailing')
  test(verbing('swiming'), 'swimingly')
  test(verbing('do'), 'do')

  print()
  print('not_bad')
  test(not_bad('This movie is not so bad'), 'This movie is good')
  test(not_bad('This dinner is not that bad!'), 'This dinner is good!')
  test(not_bad('This tea is not hot'), 'This tea is not hot')
  test(not_bad("It's bad yet not"), "It's bad yet not")

  print()
  print('front_back')
  test(front_back('abcd', 'xy'), 'abxcdy')
  test(front_back('abcde', 'xyz'), 'abcxydez')
  test(front_back('Kitten', 'Donut'), 'KitDontenut')

if __name__ == '__main__':
  main()
