#!/bin/sh

cat personal_infomation.csv | awk -F, 'NR>1{print $4,$7}' | sort -k 2,2 -t ' ' -r | uniq -c | awk 'NR%2!=0{printf $_} NR%2==0{print $_}' | awk '{print $1+$4,$2,$1,$5,$4,$3}' | awk 'length($1)==3{print $_} length($1)==2{print " "$_}' | sort -k 1,1 -k 3,3 -r
