package com.thinkConstructive.rest_demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkConstructive.rest_demo.model.CloudVendor;
import com.thinkConstructive.rest_demo.service.CloudVendorService;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

	CloudVendorService cloudVendorService;

	public CloudVendorController(CloudVendorService cloudVendorService) {
		super();
		this.cloudVendorService = cloudVendorService;
	}

	// read specific cloud vendor from db
	@GetMapping("{vendorId}")
	public CloudVendor getCloudVendor(@PathVariable("vendorId") String vendorId) {

		return cloudVendorService.getCloudVendor(vendorId);

	}

	// read all cloud vendor from db
	@GetMapping
	public List<CloudVendor> getAllCloudVendor() {

		return cloudVendorService.getAllCloudVendor();

	}

	@PostMapping
	public String createCloudVendor(@RequestBody CloudVendor cloudVendor) {

		cloudVendorService.createCloudVendor(cloudVendor);
		return "Cloud Vendor details created successfully";
	}

	@PutMapping
	public String updateCloudVendor(@RequestBody CloudVendor cloudVendor) {

		cloudVendorService.updateCloudVendor(cloudVendor);
		return "Cloud Vendor details updated successfully";
	}

	@DeleteMapping("{vendorId}")
	public String deleteCloudVendor(@PathVariable String vendorId) {

		cloudVendorService.deleteCloudVendor(vendorId);
		return "The cloud vendor details deleted successfully";

	}

}
