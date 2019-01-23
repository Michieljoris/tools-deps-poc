//Add npm dep to package.json, then collect what you need here by importing it
//into this index.js module, and adding globals. Then add the globals to
//foreign-libs in revolt.edn as namespaces

import React from 'react';
import ReactDOM from 'react-dom';
window.React = React;
window.ReactDOM = ReactDOM;

//https://github.com/mui-org/material-ui/tree/v0.x
// window.MaterialUI = {};

// import stylesGetMuiTheme from 'material-ui/styles/getMuiTheme';
// window.MaterialUI.stylesGetMuiTheme = stylesGetMuiTheme;
// import stylesMuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
// window.MaterialUI.stylesMuiThemeProvider = stylesMuiThemeProvider;
// import stylesColors from 'material-ui/styles/colors';
// window.MaterialUI.stylesColors = stylesColors;

// import {List, makeSelectable, ListItem} from 'material-ui/List';
// window.MaterialUI.List = List;
// window.MaterialUI.ListItem = ListItem;
// window.MaterialUI.makeSelectable = makeSelectable;

// import makeSelectable from 'material-ui/makeSelectable';
// window.MaterialUI.makeSelectable = makeSelectable;
import * as MaterialUI from 'material-ui'
window.MaterialUI = MaterialUI;

import * as MaterialUIStyles from 'material-ui/styles'
window.MaterialUIStyles = MaterialUIStyles;

// import AppBar from 'material-ui/AppBar';
// window.MaterialUI.AppBar = AppBar;
// import AutoComplete from 'material-ui/AutoComplete';
// window.MaterialUI.AutoComplete = AutoComplete;
// import Checkbox from 'material-ui/Checkbox';
// window.MaterialUI.Checkbox = Checkbox;
// import Chip from 'material-ui/Chip';
// window.MaterialUI.Chip = Chip;
// import Dialog from 'material-ui/Dialog';
// window.MaterialUI.Dialog = Dialog;
// import Divider from 'material-ui/Divider';
// window.MaterialUI.Divider = Divider;
// import Drawer from 'material-ui/Drawer';
// window.MaterialUI.Drawer = Drawer;
// import DropDownMenu from 'material-ui/DropDownMenu';
// window.MaterialUI.DropDownMenu = DropDownMenu;
// import FlatButton from 'material-ui/FlatButton';
// window.MaterialUI.FlatButton = FlatButton;
// import FontIcon from 'material-ui/FontIcon';
// window.MaterialUI.FontIcon = FontIcon;
// import RaisedButton from 'material-ui/RaisedButton';
// window.MaterialUI.RaisedButton = RaisedButton;
// import IconButton from 'material-ui/IconButton';
// window.MaterialUI.IconButton = IconButton;
// import IconMenu from 'material-ui/IconMenu';
// window.MaterialUI.IconMenu = IconMenu;
// import Menu from 'material-ui/Menu';
// window.MaterialUI.Menu = Menu;
// import Paper from 'material-ui/Paper';
// window.MaterialUI.Paper = Paper;
// import Popover from 'material-ui/Popover';
// window.MaterialUI.Popover = Popover;
// import RadioButton from 'material-ui/RadioButton';
// window.MaterialUI.RadioButton = RadioButton;
// import Subheader from 'material-ui/Subheader';
// window.MaterialUI.Subheader = Subheader;
// import SvgIcon from 'material-ui/SvgIcon';
// window.MaterialUI.SvgIcon = SvgIcon;
// import Snackbar from 'material-ui/Snackbar';
// window.MaterialUI.Snackbar = Snackbar;
// import TextField from 'material-ui/TextField';
// window.MaterialUI.TextField = TextField;
// import Toggle from 'material-ui/Toggle';
// window.MaterialUI.Toggle = Toggle;
// import Toolbar from 'material-ui/Toolbar';
// window.MaterialUI.Toolbar = Toolbar;
