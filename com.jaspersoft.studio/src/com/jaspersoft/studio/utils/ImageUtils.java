/*******************************************************************************
 * Copyright (C) 2005 - 2014 TIBCO Software Inc. All rights reserved.
 * http://www.jaspersoft.com.
 * 
 * Unless you have purchased  a commercial license agreement from Jaspersoft,
 * the following license terms  apply:
 * 
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
package com.jaspersoft.studio.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.wb.swt.ResourceManager;

/**
 * Utility class for managing image related stuff.
 * <p>
 * Methods in this class could manage OS resources like fonts, colors besides images. When adding new methods, please
 * add any useful notes regarding the disposal of these resources.
 * 
 * @author mrabbi
 * 
 */
public class ImageUtils {

	private static final List<String> IMG_FILE_EXTENSIONS;

	static {
		// A list of the most common image file extension
		IMG_FILE_EXTENSIONS = new ArrayList<String>();
		IMG_FILE_EXTENSIONS.add("png");
		IMG_FILE_EXTENSIONS.add("gif");
		IMG_FILE_EXTENSIONS.add("jpg");
		IMG_FILE_EXTENSIONS.add("jpeg");
		IMG_FILE_EXTENSIONS.add("bmp");
		IMG_FILE_EXTENSIONS.add("tiff");
	}

	private ImageUtils() {
	}

	/**
	 * Gets a new resized image from the specified original one.
	 * <p>
	 * Please note that the source image is not disposed or directly modified. The rescaled image returned is not cached
	 * and it is up to the caller to dispose it when no longer needed in its code.
	 * 
	 * @param originalImage
	 *          the original image
	 * @param width
	 *          the new width of the image
	 * @param height
	 *          the new height of the image
	 * @return the resized image
	 */
	public static Image resize(Image originalImage, int width, int height) {
		// Sanity checks
		Assert.isNotNull(originalImage, "The image to resize can not be null.");
		Assert.isTrue(!originalImage.isDisposed(), "The image to resize is disposed.");
		Assert.isTrue(width > 1, "Please specify a valid width value for the new image.");
		Assert.isTrue(height > 1, "Please specify a valid height value for the new image.");
		// Perform resize operation using anti-alias and interpolation settings
		Image scaled = new Image(Display.getDefault(), width, height);
		GC gc = new GC(scaled);
		try {
			gc.setAntialias(SWT.ON);
			gc.setInterpolation(SWT.HIGH);
			gc.drawImage(originalImage, 0, 0, originalImage.getBounds().width, originalImage.getBounds().height, 0, 0, width,
					height);
		} finally {
			gc.dispose();
		}
		return scaled;
	}

	/**
	 * Gets a new resized image from the specified original one. The new image 
	 * must be bigger of the original one and the original will not resized but padded
	 * with a specified color. The original image will be centered on the new one. If
	 * the new image has the same size of the original for both width and height then 
	 * the original image is returned
	 * <p>
	 * Please note that the source image is not disposed or directly modified. The rescaled image returned is not cached
	 * and it is up to the caller to dispose it when no longer needed in its code.
	 * 
	 * @param originalImage the original image, not null and not disposed
	 * @param width the new width of the image, must be greater or equals of the original
	 * @param height the new height of the image, must be greater or equal of the original
	 * @param backGround the background color used to pad the image
	 * @return the resized image
	 */
	public static Image padImage(Image originalImage, int width, int height, RGB backGround) {
		// Sanity checks
		Assert.isNotNull(originalImage, "The image to resize can not be null.");
		Assert.isTrue(!originalImage.isDisposed(), "The image to resize is disposed.");
		Assert.isTrue(width >= originalImage.getImageData().width, "Please specify a valid width value for the new image.");
		Assert.isTrue(height >= originalImage.getImageData().height, "Please specify a valid height value for the new image.");
		int originalHeight = originalImage.getImageData().height;
		int originalWidth = originalImage.getImageData().width;
		if (width == originalWidth && height == originalHeight) return originalImage;
		// Perform resize operation using anti-alias and interpolation settings
		Image scaled = new Image(Display.getDefault(), width, height);
		GC gc = new GC(scaled);
		try {
			gc.setAntialias(SWT.ON);
			gc.setInterpolation(SWT.HIGH);
			gc.setBackground(ResourceManager.getColor(backGround));
			gc.fillRectangle(0, 0, width, height);
			int destX = (width-originalImage.getImageData().width)/2;
			int destY = (height-originalImage.getImageData().height)/2;
			gc.drawImage(originalImage, 0, 0, originalImage.getBounds().width, originalImage.getBounds().height, destX, destY, originalHeight,
					originalWidth);
		} finally {
			gc.dispose();
		}
		return scaled;
	}

	/**
	 * Checks if the specified extension is a valid one for a potential image file.
	 * 
	 * @param extension
	 * @return <code>true</code> if it is a valid extension, <code>false</code> otherwise
	 */
	public static boolean hasValidFileImageExtension(String extension) {
		for (String ext : IMG_FILE_EXTENSIONS) {
			if (ext.equalsIgnoreCase(extension))
				return true;
		}
		return false;
	}

	/**
	 * @return the list of allowed file extensions for images
	 */
	public static List<String> getAllowedImageFileExtensions() {
		return IMG_FILE_EXTENSIONS;
	}
}
