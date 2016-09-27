package com.sasd13.goinfromania.controller;

public interface ICommandFactory {

	ICommand make(String code);
}
