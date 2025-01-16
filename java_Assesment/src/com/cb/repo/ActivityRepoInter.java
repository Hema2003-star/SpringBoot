package com.cb.repo;

import java.util.List;

import com.cb.model.TelecomActivity;

public interface ActivityRepoInter {
	
	public boolean doInsertLog(TelecomActivity activity);
	public TelecomActivity doFindLog(int id) ;
	public List<TelecomActivity> doFindAllLog();

}
