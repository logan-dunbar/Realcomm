package com.openbox.realcomm.services;

import com.openbox.realcomm.utilities.helpers.DownloadDatabaseHelper;
import com.openbox.realcomm.utilities.helpers.UploadBeaconsHelper;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.content.LocalBroadcastManager;

public class WebService extends CustomIntentService
{
	public static final String ROOT_API_URL = "https://realcommapi.azurewebsites.net/api/default/";
	// public static final String ROOT_API_URL = "http://obtestweb.openbox.local/realcomm_test/api/default/";

	public static final String DOWNLOAD_DATABASE_ACTION = "com.openbox.realcomm.DOWNLOAD_DATABASE";
	public static final String UPLOAD_BEACONS_ACTION = "com.openbox.realcomm.UPLOAD_BEACONS";

	public static final String DOWNLOAD_STARTING_INTENT = "com.openbox.realcomm.DOWNLOAD_STARTING";
	public static final String DOWNLOAD_FINISHED_INTENT = "com.openbox.realcomm.DOWNLOAD_FINISHED";

	private DownloadDatabaseHelper downloadDatabaseHelper;
	private UploadBeaconsHelper uploadBeaconsHelper;

	private boolean isDownloading = false;
	private boolean isUploading = false;

	public WebService()
	{
		// Elevate priority slightly
		super("WebService", Thread.NORM_PRIORITY + 1);
	}

	@Override
	public void onCreate()
	{
		super.onCreate();

		// TODO see if can't get rid of passing Context in (possible memory leak)
		// TODO create a table holding the most recent update date (fixes need for context, and download on first use)
		this.downloadDatabaseHelper = new DownloadDatabaseHelper(this);
		this.uploadBeaconsHelper = new UploadBeaconsHelper();
	}

	@Override
	protected void onHandleIntent(Intent intent)
	{
		boolean connected = checkConnectivity();

		if (connected)
		{
			if (intent.getAction().equals(DOWNLOAD_DATABASE_ACTION) && !isDownloading)
			{
				checkUpdateNeeded();
			}
			else if (intent.getAction().equals(UPLOAD_BEACONS_ACTION) && !isUploading)
			{
				uploadBeacons();
			}
		}
	}

	private boolean checkConnectivity()
	{
		// Check the network connectivity situation
		ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

		// TODO Can maybe do something here with the different connections
		// NetworkInfo mobileNetworkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		// NetworkInfo wifiNetworkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

		return activeNetworkInfo == null || !activeNetworkInfo.isConnected() ? false : activeNetworkInfo.isConnected();
	}

	private void checkUpdateNeeded()
	{
		this.isDownloading = true;

		boolean checkUpdateSucceeded = this.downloadDatabaseHelper.checkUpdateNeeded();

		if (checkUpdateSucceeded && this.downloadDatabaseHelper.getUpdateNeeded())
		{
			downloadDatabase();
		}
		else
		{
			// TODO Timer to try again based on error?
		}

		this.isDownloading = false;
	}

	private void downloadDatabase()
	{
		Intent startingIntent = new Intent(DOWNLOAD_STARTING_INTENT);
		LocalBroadcastManager.getInstance(this).sendBroadcast(startingIntent);

		boolean downloadSucceeded = this.downloadDatabaseHelper.downloadDatabase();

		if (downloadSucceeded)
		{
			boolean writeSucceeded = this.downloadDatabaseHelper.writeDatabase();

			if (writeSucceeded)
			{
				Intent finishedIntent = new Intent(DOWNLOAD_FINISHED_INTENT);
				LocalBroadcastManager.getInstance(this).sendBroadcast(finishedIntent);
			}
		}
		else
		{
			// TODO Timer to try again based on error?
		}
	}

	private void uploadBeacons()
	{
		// Used to prevent multiple calls here in onHandleIntent()
		this.isUploading = true;

		boolean uploadSucceeded = this.uploadBeaconsHelper.uploadBeaconRangingData();
		if (uploadSucceeded)
		{
			// Do something?
		}
		else
		{
			// Do something?
		}

		this.isUploading = false;
	}
}
