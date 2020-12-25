@echo off
echo decompile start
cd data
rmdir /s/q demo
call apktool d demo.apk
cd ..
echo decompile end