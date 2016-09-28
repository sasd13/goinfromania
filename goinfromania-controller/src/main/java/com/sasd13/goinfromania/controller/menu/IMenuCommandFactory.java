package com.sasd13.goinfromania.controller.menu;

import com.sasd13.goinfromania.controller.ICommand;

public interface IMenuCommandFactory {

	ICommand make(String code);
}
