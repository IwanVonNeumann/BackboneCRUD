/**
 * Created by User on 02.08.2015
 */

$(document).ready(function () {

    var Application = new Marionette.Application();

    Application.addRegions({
        main: "#application"
    });

    var PeopleCollection = Backbone.Collection.extend({
        url: "/contacts"
    });

    var ContactView = Marionette.ItemView.extend({
        initialize: function () {
            this.listenTo(this.model, "change", this.render);
        },

        template: "#person",
        tagName: "tr",

        events: {
            "click button.js-edit": "editContact",
            "click button.js-delete": "deleteContact"
        },

        editContact: function (e) {
            e.stopPropagation();
            var model = this.model;
            bootbox.prompt({
                title: "Edit contact",
                value: model.get("name"),
                size: "small",
                callback: function (result) {
                    if (result) {
                        model.set("name", result);
                        model.save();
                    }
                }
            });
        },

        deleteContact: function (e) {
            e.stopPropagation();
            var model = this.model;
            bootbox.confirm({
                title: "Delete contact",
                message: "Are you sure?",
                size: "small",
                callback: function (result) {
                    if (result) {
                        model.destroy();
                    }
                }
            });
        }
    });

    var PeopleCollectionView = Marionette.CompositeView.extend({
        initialize: function () {
            this.collection = new PeopleCollection();
            this.collection.fetch();
        },
        template: "#contacts",
        childViewContainer: "tbody",
        childView: ContactView,

        events: {
            "click button.js-new" : "createContact"
        },

        createContact: function (e) {
            e.stopPropagation();
            var collection = this.collection;
            bootbox.prompt({
                title: "Create contact",
                size: "small",
                callback: function (result) {
                    if (result) {
                        collection.create({
                            name: result
                        });
                    }
                }
            });
        }
    });

    Application.addInitializer(function () {
        Application.main.show(new PeopleCollectionView());
    });

    Application.start();
});
