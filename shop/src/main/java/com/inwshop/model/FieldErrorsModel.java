package com.inwshop.model;

public class FieldErrorsModel {

    private String field;
        private String defaultMessage;

        public FieldErrorsModel(){}

        public FieldErrorsModel(String field, String defaultMessage) {
            this.field = field;
            this.defaultMessage = defaultMessage;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getDefaultMessage() {
            return defaultMessage;
        }

        public void setDefaultMessage(String defaultMessage) {
            this.defaultMessage = defaultMessage;
        }
}
