package com.openbox.realcomm.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.openbox.realcomm.base.BaseFragment;
import com.openbox.realcomm.utilities.enums.AppMode;
import com.openbox.realcomm.utilities.interfaces.AppModeChangedCallbacks;
import com.openbox.realcomm.R;

public class ConnectionStatusFragment extends BaseFragment implements AppModeChangedCallbacks
{
	private static final String CONNECTION_STATUS_PREFIX = "Status: ";

	private TextView connectionStatusTextView;

	public static ConnectionStatusFragment newInstance()
	{
		ConnectionStatusFragment fragment = new ConnectionStatusFragment();

		return fragment;
	}

	/**********************************************************************************************
	 * Fragment Lifecycle Implements
	 **********************************************************************************************/
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View view = inflater.inflate(R.layout.fragment_connection_status, container, false);

		this.connectionStatusTextView = (TextView) view.findViewById(R.id.connectionStatusTextView);

		updateView();

		return view;
	}

	/**********************************************************************************************
	 * App Mode Changed Callbacks
	 **********************************************************************************************/
	@Override
	public void onAppModeChanged(AppMode newAppMode, AppMode previousAppMode)
	{
		updateView();
	}

	/**********************************************************************************************
	 * Private Helper Methods
	 **********************************************************************************************/
	private void updateView()
	{
		if (getAppModeInterface() != null && getAppModeInterface().getCurrentAppMode() != null)
		{
			// TODO maybe add color or something
			this.connectionStatusTextView.setText(CONNECTION_STATUS_PREFIX + getAppModeInterface().getCurrentAppMode().getDisplayName());
		}
	}
}
