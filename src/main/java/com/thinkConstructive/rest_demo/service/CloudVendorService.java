package com.thinkConstructive.rest_demo.service;


import java.util.List;

import com.thinkConstructive.rest_demo.model.CloudVendor;

public interface CloudVendorService {
	
	public String createCloudVendor(CloudVendor cloudVendor);
	public CloudVendor getCloudVendor(String vendorId);
	public String updateCloudVendor(CloudVendor cloudVendor);
	public String deleteCloudVendor(String vendorId);
	public List<CloudVendor> getAllCloudVendor();

}
