# File System Generator using Composite Design Pattern
With this program you can simulate creation of a file system of folders and regular files.

I illustrate my OOP knowledge by implementing composite design pattern to accomplish this task.

Although there are some known bugs, my main goal of implementing the design pattern is achieved.

[JavaDoc](api/index.html)

## Run Examples
### The input and output are through the terminal
#### Example 1
**input:** <br>
/home/user/documents<br>
/home/user/documents/file1.txt<br>
/home/user/documents/folder1<br>
/home/user/documents/folder1/file2.txt<br>
/home/user/pictures<br>
abc/def<br>
exit

**output:** <br>
Directory: /root<br>
Directory: /root/home<br>
Directory: /root/home/user<br>
Directory: /root/home/user/documents<br>
File:      /root/home/user/documents/file1.txt<br>
Directory: /root/home/user/documents/folder1<br>
File:      /root/home/user/documents/folder1/file2.txt<br>
Directory: /root/home/user/pictures<br>
Directory: /root/abc<br>
Directory: /root/abc/def

#### Example 2
**input:** <br>
/home/user<br>
/home/user/documents<br>
/home/user/documents/file1.txt<br>
/home/user/documents/file1.txt/invalid<br>
/home/user/pictures<br>
/home/user/pictures/photo.jpg<br>
/home/user/pictures/photo.jpg/album<br>
exit

**output:** <br>
Can't add the path 'file1.txt/invalid' in the simple file 'file1.txt'<br>
Can't add the path 'photo.jpg/album' in the simple file 'photo.jpg'<br>
Directory: /root<br>
Directory: /root/home<br>
Directory: /root/home/user<br>
Directory: /root/home/user/documents<br>
File:      /root/home/user/documents/file1.txt<br>
Directory: /root/home/user/pictures<br>
File:      /root/home/user/pictures/photo.jpg<br>

