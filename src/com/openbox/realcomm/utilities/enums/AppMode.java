package com.openbox.realcomm.utilities.enums;

public enum AppMode
{
	INITIALIZING("Initializing", -1, -1),
	OFFLINE("Offline", 1500, 7000),
	ONLINE("Online", 1500, 2000),
	OUT_OF_RANGE("Out of Range", 500, 7000);

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
