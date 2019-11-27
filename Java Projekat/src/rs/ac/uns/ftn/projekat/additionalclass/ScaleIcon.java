package rs.ac.uns.ftn.projekat.additionalclass;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ScaleIcon {
		
	public static ImageIcon ScaleIconSize(String path) {
		ImageIcon image = new ImageIcon(path);
		Image i = image.getImage();
		Image newimg = i.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
		ImageIcon ret = new ImageIcon(newimg);
		return ret;
	}

}
