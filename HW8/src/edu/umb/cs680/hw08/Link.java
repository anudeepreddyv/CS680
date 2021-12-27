package edu.umb.cs680.hw08;
import java.time.LocalDateTime;
public class Link extends FSElement{
	public FSElement getTarget() {
		return target;
	}
	@Override
	public boolean isDirectory() {
		return false;
	}
	public Link(Directory parent, String name, int size, LocalDateTime creationTime, FSElement target) {
		super(parent, name, size, creationTime);
		this.target = target;
		parent.appendChild(this);
	}
	private FSElement target;
	public static void main(String[] args) {
		System.out.println("Success");
	}
}