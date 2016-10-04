package com.sasd13.goinfromania.view.lifecycle;

import com.sasd13.goinfromania.bean.EnumState;
import com.sasd13.goinfromania.view.FrameView;

public class CycleFactory {

	private CycleFactory() {
	}

	public static ICycle make(int order, FrameView frameView) {
		if (EnumState.CREATED.getOrder() == order) {
			return new CreateCycle();
		} else if (EnumState.STARTED.getOrder() == order) {
			return new StartCycle();
		} else if (EnumState.RESUMED.getOrder() == order) {
			return new ResumeCycle();
		} else if (EnumState.PAUSED.getOrder() == order) {
			return new PauseCycle();
		} else if (EnumState.STOPPED.getOrder() == order) {
			return new StopCycle(frameView);
		} else if (EnumState.DESTROYED.getOrder() == order) {
			return new DestroyCycle();
		} else {
			return null;
		}
	}
}
