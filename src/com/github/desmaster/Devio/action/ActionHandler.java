package com.github.desmaster.Devio.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ActionHandler {

	public List<Action> derp = new ArrayList<Action>();

	public ActionHandler() {

	}

	public void tick() {
		Iterator<Action> iterator = derp.iterator();
		while (iterator.hasNext()) {
			iterator.next().tick();
		}
	}

}
