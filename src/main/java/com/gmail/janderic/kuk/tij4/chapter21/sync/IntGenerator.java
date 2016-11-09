package com.gmail.janderic.kuk.tij4.chapter21.sync;

/**
 * 顶层Int数字生成器
 */
public abstract class IntGenerator {
	private volatile boolean isCancel = false;
	protected abstract int next();
	public boolean isCanceled() {
		return isCancel;
	}
	public void cancel() {
		isCancel = true;
	}
}
