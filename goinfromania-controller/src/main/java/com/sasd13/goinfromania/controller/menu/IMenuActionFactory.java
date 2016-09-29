package com.sasd13.goinfromania.controller.menu;

import com.sasd13.goinfromania.controller.IAction;

public interface IMenuActionFactory {

	IAction make(String code);
}
