package com.thinkConstructive.rest_demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.thinkConstructive.rest_demo.model.CloudVendor;
import com.thinkConstructive.rest_demo.repository.CloudVendorRepository;
import com.thinkConstructive.rest_demo.service.CloudVendorService;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

	CloudVendorRepository cloudVendorRepository;
	
	//constructor
	public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
		super();
		this.cloudVendorRepository = cloudVendorRepository;
	}

	@Override
	public String createCloudVendor(CloudVendor cloudVendor) {
		cloudVendorRepository.save(cloudVendor);
		return "created successfully";
	}

	@Override
	public CloudVendor getCloudVendor(String vendorId) {

		return cloudVendorRepository.findById(vendorId).get();
	}

	@Override
	public String updateCloudVendor(CloudVendor cloudVendor) {
		cloudVendorRepository.save(cloudVendor);
		return "update successfully";
	}

	@Override
	public String deleteCloudVendor(String vendorId) {

		cloudVendorRepository.deleteById(vendorId);
		return "cloud vendor details deleted successfully";

	}

	@Override
	public List<CloudVendor> getAllCloudVendor() {

		return cloudVendorRepository.findAll();
	}

}
