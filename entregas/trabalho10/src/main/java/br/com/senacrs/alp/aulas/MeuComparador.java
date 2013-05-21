package br.com.senacrs.alp.aulas;

import java.io.File;
import java.util.Comparator;

public class MeuComparador implements Comparator<File> {

@Override
public int compare(File f1, File f2) {
	if (f1.isDirectory() && !f2.isDirectory()) {
		return -1;
	} 
	if (!f1.isDirectory() && f2.isDirectory()) {
		return 1;
	} 
	return f1.getName().compareTo(f2.getName());
}


}