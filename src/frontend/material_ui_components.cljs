(ns components.material-ui
  (:refer-clojure :exclude [list stepper])
  (:require [clojure.walk :refer [postwalk]]
            [sablono.util :refer [camel-case camel-case-keys]]

            [react :as react]
            [material-ui :as ui]
            [material-ui-styles :as ui-styles]

            [taoensso.timbre :as timbre]
            ))

(defn transform-keys [t coll]
  "Recursively transforms all map keys in coll with t."
  (letfn [(transform [[k v]] [(t k) v])]
    (postwalk (fn [x] (if (map? x) (into {} (map transform x)) x)) coll)))

(def props-kebab->camel->js (comp clj->js camel-case-keys))


(defn create-mui-cmp
  ([react-class args]
   (let [first-arg (first args)
         args (if (or (map? first-arg) (nil? first-arg)) args (cons {} args))]
     (apply react/createElement react-class
            (props-kebab->camel->js (first args)) (rest args)))))

(defn get-mui-theme
  ([] (get-mui-theme nil))
  ([raw-theme] (->> raw-theme
                 (transform-keys camel-case)
                 clj->js
                 ui-styles/getMuiTheme)))

(defn color [color-key]
  (aget ui/stylesColors (name (camel-case color-key))))


(defn selectable-list [& args] (create-mui-cmp (ui/makeSelectable ui/List) args))

(defn mui-theme-provider [& args] (create-mui-cmp ui-styles/MuiThemeProvider args))

(defn app-bar [& args] (create-mui-cmp ui/AppBar args))
(defn auto-complete [& args] (create-mui-cmp ui/AutoComplete args))
;; (defn avatar [& args] (create-mui-cmp ui/Avatar args))
;; (defn badge [& args] (create-mui-cmp ui/Badge args))
;; (defn bottom-navigation [& args] (create-mui-cmp ui/BottomNavigation args))
;; (defn bottom-navigation-item [& args] (create-mui-cmp ui/BottomNavigationItem args))
;; (defn card [& args] (create-mui-cmp ui/Card args))
;; (defn card-actions [& args] (create-mui-cmp ui/CardActions args))
;; (defn card-header [& args] (create-mui-cmp ui/CardHeader args))
;; (defn card-media [& args] (create-mui-cmp ui/CardMedia args))
;; (defn card-title [& args] (create-mui-cmp ui/CardTitle args))
;; (defn card-text [& args] (create-mui-cmp ui/CardText args))
(defn checkbox [& args] (create-mui-cmp ui/Checkbox args))
(defn chip [& args] (create-mui-cmp ui/Chip args))
;; (defn circular-progress [& args] (create-mui-cmp ui/CircularProgress args))
;; (defn date-picker [& args] (create-mui-cmp ui/DatePicker args))
(defn dialog [& args] (create-mui-cmp ui/Dialog args))
(defn divider [& args] (create-mui-cmp ui/Divider args))
(defn drawer [& args] (create-mui-cmp ui/Drawer args))
(defn drop-down-menu [& args] (create-mui-cmp ui/DropDownMenu args))
(defn flat-button [& args] (create-mui-cmp ui/FlatButton args))
;; (defn floating-action-button [& args] (create-mui-cmp ui/FloatingActionButton args))
(defn font-icon [& args] (create-mui-cmp ui/FontIcon args))
;; (defn grid-list [& args] (create-mui-cmp ui/GridList args))
;; (defn grid-tile [& args] (create-mui-cmp ui/GridTile args))
(defn icon-button [& args] (create-mui-cmp ui/IconButon args))
(defn icon-menu [& args] (create-mui-cmp ui/IconMenu args))
;; (defn linear-progress [& args] (create-mui-cmp ui/LinearProgress args))
(defn list [& args] (create-mui-cmp ui/List args))
(defn list-item [& args] (create-mui-cmp ui/ListItem args))
(defn menu [& args] (create-mui-cmp ui/Menu args))
(defn menu-item [& args] (create-mui-cmp ui/MenuItem args))
(defn paper [& args] (create-mui-cmp ui/Paper args))
(defn popover [& args] (create-mui-cmp ui/Popover args))
(defn radio-button [& args] (create-mui-cmp ui/RadioButton args))
(defn radio-button-group [& args] (create-mui-cmp ui/RadioButtonGroup args))
(defn raised-button [& args] (create-mui-cmp ui/RaisedButton args))
;; (defn refresh-indicator [& args] (create-mui-cmp ui/RefreshIndicator args))
;; (defn select-field [& args] (create-mui-cmp ui/SelectField args))
;; (defn slider [& args] (create-mui-cmp ui/Slider args))
(defn subheader [& args] (create-mui-cmp ui/Subheader args))
(defn svg-icon [& args] (create-mui-cmp ui/SvgIcon args))

;; (defn step [& args] (create-mui-cmp ui/Step args))
;; (defn step-button [& args] (create-mui-cmp ui/StepButton args))
;; (defn step-content [& args] (create-mui-cmp ui/StepContent args))
;; (defn step-label [& args] (create-mui-cmp ui/StepLabel args))
;; (defn stepper [& args] (create-mui-cmp ui/Stepper args))
(defn snackbar [& args] (create-mui-cmp ui/Snackbar args))
;; (defn tabs [& args] (create-mui-cmp ui/Tabs args))
;; (defn tab [& args] (create-mui-cmp ui/Tab args))
;; (defn table [& args] (create-mui-cmp ui/Table args))
;; (defn table-body [& args] (create-mui-cmp ui/TableBody args))
;; (defn table-footer [& args] (create-mui-cmp ui/TableFooter args))
;; (defn table-header [& args] (create-mui-cmp ui/TableHeader args))
;; (defn table-header-column [& args] (create-mui-cmp ui/TableHeaderColumn args))
;; (defn table-row [& args] (create-mui-cmp ui/TableRow args))
;; (defn table-row-column [& args] (create-mui-cmp ui/TableRowColumn args))
(defn text-field [& args] (create-mui-cmp ui/TextField args))
;; (defn time-picker [& args] (create-mui-cmp ui/TimePicker args))
(defn toggle [& args] (create-mui-cmp ui/Toggle args))
(defn toolbar [& args] (create-mui-cmp ui/Toolbar args))
(defn toolbar-group [& args] (create-mui-cmp ui/ToolbarGroup args))
(defn toolbar-separator [& args] (create-mui-cmp ui/ToolbarSeparator args))
(defn toolbar-title [& args] (create-mui-cmp ui/ToolbarTitle args))
