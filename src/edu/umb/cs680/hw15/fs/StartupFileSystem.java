package edu.umb.cs680.hw15.fs;
import edu.umb.cs680.hw15.apfs.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StartupFileSystem {
	public static void main(String[] args)
	{
        APFS apfs = new APFS("new apfs", 1024);
        apfs.initFileSystem("new apfs", 1024);

        ApfsDirectory root = new ApfsDirectory(null, "root", 0, LocalDateTime.now(), null); 
        ApfsDirectory home = new ApfsDirectory(root, "home", 0, LocalDateTime.now(), null);
        ApfsDirectory applications = new ApfsDirectory(root, "applications", 0, LocalDateTime.now(), null);
        ApfsDirectory code = new ApfsDirectory(home, "code", 0, LocalDateTime.now(), null);
        
        ApfsFile a = new ApfsFile(null, "a.txt", 8, LocalDateTime.now(), null);
        ApfsFile b = new ApfsFile(null, "b.txt", 16, LocalDateTime.now(), null);
        ApfsFile c = new ApfsFile(null, "c.txt", 32, LocalDateTime.now(), null);
        ApfsFile d = new ApfsFile(null, "d.txt", 64, LocalDateTime.now(), null);
        ApfsFile e = new ApfsFile(null, "e.txt", 128, LocalDateTime.now(), null);
        ApfsFile f = new ApfsFile(null, "f.txt", 256, LocalDateTime.now(), null);

        ApfsLink x = new ApfsLink(home, "linkToApplications", 0, LocalDateTime.now(), applications);
        ApfsLink y = new ApfsLink(code, "linkToFileB", 0, LocalDateTime.now(), b); 

        apfs.appendRootDir(root);
        root.appendChild(applications);
        root.appendChild(home);
        home.appendChild(code);
        applications.appendChild(a);
        applications.appendChild(b);
        home.appendChild(c);
        home.appendChild(d);
        home.appendChild(x);
        code.appendChild(e);
        code.appendChild(f);
        code.appendChild(y);

        String alpha = "alphabetical";
        String reverseAlpha = "reverse alphabetical";
        String size = "size";
        String reverseSize = "reverse size";
        

        System.out.println("-------- A to Z --------\n");
        System.out.println("-- Children --");
        for (FSElement child: root.getChildren(alpha)) {
                System.out.println(child + "\n");
        }
        System.out.println("-- SubDirectories --");
        for (FSElement subDirectory: root.getSubDirectories(alpha)) {
                        System.out.println(subDirectory + "\n");
        }
        System.out.println("-- Files --");
        for (FSElement file: home.getFiles(alpha)) {
			System.out.println(file + "\n");
        }
        System.out.println("-- Links --");
        for (FSElement link: home.getLinks(alpha)) {
			System.out.println(link + "\n");
        }

        System.out.println("-------- Z to A --------\n");
        System.out.println("-- Children --");
        for (FSElement child: root.getChildren(reverseAlpha)) {
                System.out.println(child + "\n");
        }
        System.out.println("-- SubDirectories --");
        for (FSElement subDirectory: root.getSubDirectories(reverseAlpha)) {
                        System.out.println(subDirectory + "\n");
        }
        System.out.println("-- Files --");
        for (FSElement file: home.getFiles(reverseAlpha)) {
			System.out.println(file + "\n");
        }
        System.out.println("-- Links --");
        for (FSElement link: home.getLinks(reverseAlpha)) {
			System.out.println(link + "\n");
        }

        System.out.println("-------- File Size --------\n");
        System.out.println("-- Children --");
        for (FSElement child: root.getChildren(size)) {
                System.out.println(child + "\n");
        }
        System.out.println("-- SubDirectories --");
        for (FSElement subDirectory: root.getSubDirectories(size)) {
                        System.out.println(subDirectory + "\n");
        }
        System.out.println("-- Files --");
        for (FSElement file: home.getFiles(size)) {
			System.out.println(file + "\n");
        }
        System.out.println("-- Links --");
        for (FSElement link: home.getLinks(size)) {
			System.out.println(link + "\n");
        }

        
        System.out.println("-------- Reverse File Size --------\n");
        System.out.println("-- Children --");
        for (FSElement child: root.getChildren(reverseSize)) {
                System.out.println(child + "\n");
        }
        System.out.println("-- SubDirectories --");
        for (FSElement subDirectory: root.getSubDirectories(reverseSize)) {
                        System.out.println(subDirectory + "\n");
        }
        System.out.println("-- Files --");
        for (FSElement file: home.getFiles(reverseSize)) {
			System.out.println(file + "\n");
        }
        System.out.println("-- Links --");
        for (FSElement link: home.getLinks(reverseSize)) {
			System.out.println(link + "\n");
        }
}
}




