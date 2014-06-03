package com.openbox.realcomm3.utilities.enums;

public enum AppMode
{
	INITIALIZING("Initializing", -1, -1),
	OFFLINE("Offline", 1500, 7000),
	ONLINE("Online", 1500, 1500),
	OUTOFRANGE("Out of Range", 1500, 7000),
	PAUSED("Paused", 1500, 7000); // TODO This is a quick fix hax. should never need this

	private final String displayName;
	private final int animationStartDelay;
	private final int animationPeriod;

	private AppMode(String displayName, int animationStartDelay, int animationPeriod)
	{
		this.displayName = displayName;
		this.animationStartDelay = animationStartDelay;
		this.animationPeriod = animationPeriod;
	}

	public String getDisplayName()
	{
		return displayName;
	}

	public int getAnimationStartDelay()
	{
		return animationStartDelay;
	}

	public int getAnimationPeriod()
	{
		return animationPeriod;
	}
}
