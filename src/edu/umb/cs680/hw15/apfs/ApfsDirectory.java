package edu.umb.cs680.hw15.apfs;
import edu.umb.cs680.hw15.fs.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class ApfsDirectory extends ApfsElement
{
	private LinkedList<ApfsElement> apfsChildren = new LinkedList<ApfsElement>();
	private LinkedList<ApfsDirectory> apfsSubDirectories = new LinkedList<ApfsDirectory>();
	private LinkedList<ApfsFile> apfsFiles = new LinkedList<ApfsFile>();
	private LinkedList<ApfsLink> apfsLinks = new LinkedList<ApfsLink>();

	public ApfsDirectory(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, ApfsElement target) {
		super(parent, name, size, creationTime, target);
	}
	public void accept(ApfsVisitor v){
		v.visit(this);
		for (ApfsElement e: apfsChildren) {
			e.accept(v);
		}
	}
	public boolean inDirectory(FSElement dir) {
		return (dir == this.parent);
	}
	public boolean isDirectory() {
		return true;
	}
	public boolean isFile() {
		return false;
	}
	public boolean isLink() {
		return false;
	}

	public void appendChild(ApfsElement child) {

		if (child.isDirectory()) {
			this.apfsSubDirectories.add((ApfsDirectory)child);
			this.apfsChildren.add(child);
			child.setParent(this);			
		} else if (child.isFile()) {
			this.apfsFiles.add((ApfsFile)child);
			this.apfsChildren.add(child);
			child.setParent(this);			
		} else {
			this.apfsLinks.add((ApfsLink)child);
			this.apfsChildren.add(child);
			child.setParent(this);
		}
	}

	public LinkedList<ApfsElement> getChildren() {
		return apfsChildren;
	}
	public LinkedList<ApfsDirectory> getSubDirectories() {
		return apfsSubDirectories;
	}
	public LinkedList<ApfsFile> getFiles() {
		return apfsFiles;
	}
	public LinkedList<ApfsLink> getLinks() {
		return apfsLinks;
	}
	public ArrayList<FSElement> getChildren(String comparison) {
		ArrayList<FSElement> children = new ArrayList<FSElement>(this.apfsChildren);
		switch(comparison) {
			case "alphabetical":
				Collections.sort(children, (FSElement apfs1, FSElement apfs2) -> apfs1.getName().compareTo(apfs2.getName()));
				break;
			case "reverse alphabetical":
				Collections.sort(children, (FSElement apfs1, FSElement apfs2) -> apfs2.getName().compareTo(apfs1.getName()));
				break;
			case "size":
				Collections.sort(children, (FSElement apfs1, FSElement apfs2) -> apfs2.getSize() - apfs1.getSize());
				break;
			case "reverse size":
				Collections.sort(children, (FSElement apfs1, FSElement apfs2) -> apfs1.getSize() - apfs2.getSize());
				break;
		}
		return children;
	}

	public ArrayList<FSElement> getSubDirectories(String comparison) {
		ArrayList<FSElement> subDirectories = new ArrayList<FSElement>(this.apfsSubDirectories);
		switch(comparison) {
			case "alphabetical":
				Collections.sort(subDirectories, (FSElement apfs1, FSElement apfs2) -> apfs1.getName().compareTo(apfs2.getName()));
				break;
			case "reverse alphabetical":
				Collections.sort(subDirectories, (FSElement apfs1, FSElement apfs2) -> apfs2.getName().compareTo(apfs1.getName()));
				break;
			case "size":
				Collections.sort(subDirectories, (FSElement apfs1, FSElement apfs2) -> apfs2.getSize() - apfs1.getSize());
				break;
			case "reverse size":
			Collections.sort(subDirectories, (FSElement apfs1, FSElement apfs2) -> apfs1.getSize() - apfs2.getSize());
				break;
		}
		return subDirectories;
	}

	public ArrayList<FSElement> getFiles(String comparison) {
		ArrayList<FSElement> files = new ArrayList<FSElement>(this.apfsFiles);
		switch(comparison) {
			case "alphabetical":
				Collections.sort(files, (FSElement apfs1, FSElement apfs2) -> apfs1.getName().compareTo(apfs2.getName()));
				break;
			case "reverse alphabetical":
				Collections.sort(files, (FSElement apfs1, FSElement apfs2) -> apfs2.getName().compareTo(apfs1.getName()));
				break;
			case "size":
				Collections.sort(files, (FSElement apfs1, FSElement apfs2) -> apfs2.getSize() - apfs1.getSize());
				break;
			case "reverse size":
			Collections.sort(files, (FSElement apfs1, FSElement apfs2) -> apfs1.getSize() - apfs2.getSize());
				break;
		}
		return files;
	}

	public ArrayList<FSElement> getLinks(String comparison) {
		ArrayList<FSElement> links = new ArrayList<FSElement>(this.apfsLinks);
		switch(comparison) {
			case "alphabetical":
				Collections.sort(links, (FSElement apfs1, FSElement apfs2) -> apfs1.getName().compareTo(apfs2.getName()));
				break;
			case "reverse alphabetical":
				Collections.sort(links, (FSElement apfs1, FSElement apfs2) -> apfs2.getName().compareTo(apfs1.getName()));
				break;
			case "size":
				Collections.sort(links, (FSElement apfs1, FSElement apfs2) -> apfs2.getSize() - apfs1.getSize());
				break;
			case "reverse size":
			Collections.sort(links, (FSElement apfs1, FSElement apfs2) -> apfs1.getSize() - apfs2.getSize());
				break;
		}
		return links;
	}
	
	public int countChildren() {
		return this.apfsChildren.size();	
	}
	public int getTotalSize() {
		
		int totalSize = 0;
	
		for (ApfsFile apfsFile: this.getFiles()) {
			totalSize = totalSize + apfsFile.getSize();
		}
		return totalSize;	
	}
}

