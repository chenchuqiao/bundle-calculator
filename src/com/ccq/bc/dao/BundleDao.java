/**
 *  @ClassName BundleDao
 *  @Description Built-in Bundle data.
 *  @author ChuqiaoChen
 *  @Date 2019/10/26
 *  @Version 1.0
 */

package com.ccq.bc.dao;

import com.ccq.bc.model.Bundle;
import java.util.ArrayList;
import java.util.List;

public class BundleDao {
	
	private List<Bundle> bundles;
	
	public BundleDao() {
		bundles = new ArrayList<>();
		bundles.add(new Bundle("IMG", 5, 450));
		bundles.add(new Bundle("IMG", 10, 800));
		bundles.add(new Bundle("FLAC", 3, 427.50));
		bundles.add(new Bundle("FLAC", 6, 810));
		bundles.add(new Bundle("FLAC", 9, 1147.50));
		bundles.add(new Bundle("VID", 3, 570));
		bundles.add(new Bundle("VID", 5, 900));
		bundles.add(new Bundle("VID", 9, 1530));
	}

	public List<Bundle> getBundles() {
		return bundles;
	}
}
