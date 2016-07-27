package net.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public enum FileColor {
		red, green, blue
	};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String path = "c:/work/file.txt";

		FileColor color = FileColor.blue;

		switch (color) {
		case red:
			System.out.println("red");
			break;
		case blue:
			System.out.println("blue");
			break;
		case green:
			System.out.println("green");
			break;
		default:
		}
		File dir = new File("c:/work");
		tree(dir, 0);

		File file = new File(path);
		DecimalFormat df = new DecimalFormat("0.00KB");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");

		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!file.exists()) {
			System.out.print("File no found!");
		} else {
			double size = (double) file.length() / 1024;
			String location = file.getPath().replace(file.getName(), "");
			long last = file.lastModified();
			String text = read(file);
			System.out.println(text);
			System.out.println("LastModified: "
					+ simpleDateFormat.format(new Date(last)));
			System.out.println("Location:     " + location);
			System.out.println("Size:         " + df.format(size));
			
		}
	}

	private static String read(File file) {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String temp = "";
			while ((temp = br.readLine()) != null)
				sb.append(temp + "\n");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return sb.toString();
	}

	private static void tree(File file, int level) {
		String space = "";
		for (int i = 0; i < level; i++) {
			space += "----";
		}
		System.out.println(space + file.getName());
		File[] list = file.listFiles();
		for (File f : list) {
			if (f.isDirectory()) {
				tree(f, level + 1);
			} else {
				System.out.println(space + f.getName());
			}
		}
	}
}
