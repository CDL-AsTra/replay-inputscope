package osu.seclab.inputscope.stringvsa.main;

import java.io.File;
import java.io.IOException;
import java.util.zip.ZipException;


import soot.jimple.infoflow.android.axml.ApkHandler;
import soot.jimple.infoflow.android.manifest.ProcessManifest;
import soot.jimple.infoflow.android.resources.ARSCFileParser;

public class ApkContext {


	private static ApkContext apkcontext = null;

	public static ApkContext getInstance(String path) throws IOException {
		apkcontext = new ApkContext(path);
		return apkcontext;
	}

	public static ApkContext getInstance() {
		return apkcontext;
	}


	private final ApkHandler apkHandler;
	private ProcessManifest processManifest = null;
	private final ARSCFileParser arscFileParser;


	/**
	 * @param path to the apk
	 * @throws IOException in case of an error
	 */
	private ApkContext(String path) throws IOException {
		this.apkHandler = new ApkHandler(path);

		this.arscFileParser = new ARSCFileParser();
		this.arscFileParser.parse(this.apkHandler.getInputStream("resources.arsc"));
		try {
			this.processManifest = new ProcessManifest(apkHandler.getInputStream("AndroidManifest.xml") , this.arscFileParser );
		} catch (IOException  e) {

			System.err.println("init failed:  " + e.getMessage());
		}
		apkHandler.close();
	}

	public String getAbsolutePath() {
		return apkHandler.getAbsolutePath();
	}

	public String getPackageName() {
		try {
			if (processManifest != null)
				return processManifest.getPackageName();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return null;
	}

	public int getIdentifier(String name, String type) {
		try {
			return arscFileParser.findResourceByName(type, name).getResourceID();
		} catch (Exception e) {
			System.err.println("getIdentifier failed for" + name + " of " + type);
			return -1;
		}
	}

	/**
	 * @param id to the resource
	 * @return the resource string
	 */
	public String findResource(int id) {

		String str = "";
		try {
			str = arscFileParser.findResource(id).toString();
		} catch (Exception e) {
			str = String.format("Resources:%d", id);
			System.err.println(e.getMessage());
		}
		return str;
	}



}
