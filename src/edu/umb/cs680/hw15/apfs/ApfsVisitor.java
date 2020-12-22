package edu.umb.cs680.hw15.apfs;
import edu.umb.cs680.hw15.fs.*;

public interface ApfsVisitor
{
	public void visit(ApfsLink link);
	public void visit(ApfsDirectory dir);
	public void visit(ApfsFile file);
}


 