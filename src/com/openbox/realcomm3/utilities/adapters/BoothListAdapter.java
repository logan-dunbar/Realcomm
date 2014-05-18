package com.openbox.realcomm3.utilities.adapters;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.openbox.realcomm3.R;
import com.openbox.realcomm3.application.RealCommApplication;
import com.openbox.realcomm3.database.models.BoothModel;
import com.openbox.realcomm3.database.models.BoothListModel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;

public class BoothListAdapter extends ArrayAdapter<BoothModel>
{
	private static final String BOOTH_PREFIX = "Booth ";

	private LayoutInflater layoutInflater;
	private Resources resources;
	private RealCommApplication application;

	private List<BoothModel> fullBoothList = new ArrayList<>();
	private String filter;

	public BoothListAdapter(Context context, RealCommApplication application)
	{
		super(context, 0);
		this.resources = context.getResources();
		this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.application = application;
	}

	public void setItems(List<BoothModel> data)
	{
		if (data != null)
		{
			this.fullBoothList = data;
		}

		doFiltering();
	}

	public void filterItems(String filter)
	{
		this.filter = filter;
		doFiltering();
	}

	private void doFiltering()
	{
		clear();

		if (this.filter == null || this.filter.length() == 0)
		{
			addAll(this.fullBoothList);
		}
		else
		{
			List<BoothModel> filteredList = new ArrayList<>();
			for (BoothModel model : this.fullBoothList)
			{
				if (model.getCompanyName().toUpperCase(Locale.ENGLISH).contains(this.filter.toUpperCase(Locale.ENGLISH)) ||
					String.valueOf(model.getBoothNumber()).contains(this.filter))
				{
					filteredList.add(model);
				}
			}

			addAll(filteredList);
		}
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		View row;
		ViewHolder holder;

		if (convertView == null)
		{
			row = this.layoutInflater.inflate(R.layout.list_item_booth, null);
			holder = new ViewHolder();
			holder.circleLayout = (FrameLayout) row.findViewById(R.id.boothItemCircleLayout);
			holder.companyName = (TextView) row.findViewById(R.id.companyNameTextView);
			holder.companyName.setTypeface(this.application.getExo2Font());
			holder.boothNumber = (TextView) row.findViewById(R.id.boothNumberTextView);
			holder.boothNumber.setTypeface(this.application.getExo2Font());
			row.setTag(holder);
		}
		else
		{
			row = convertView;
			holder = (ViewHolder) row.getTag();
		}

		BoothModel model = getItem(position);
		int colorId = BoothModel.getProximityRegion(model.getAccuracy()).getColorId();
		int resolvedColorId = this.resources.getColor(colorId);

		holder.companyName.setText(model.getCompanyName());
		holder.boothNumber.setText(BOOTH_PREFIX + String.valueOf(model.getBoothNumber()));
		holder.boothNumber.setTextColor(resolvedColorId);

		GradientDrawable circle = (GradientDrawable) holder.circleLayout.getBackground();
		circle.setColor(resolvedColorId);

		return row;
	}

	static class ViewHolder
	{
		FrameLayout circleLayout;
		TextView companyName;;
		TextView boothNumber;
	}
}
