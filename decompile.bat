@echo off
echo decompile start
cd data
rmdir /s/q shell
call apktool d shell.apk
cd ..
echo decompile end