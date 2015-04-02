class App.Views.EditUser extends Backbone.View

  template: JST['users/edit']
  
  tagName: 'form'

  events:
    'submit': 'saveModel'

  render: ->
    @$el.html(@template(user: @model))
    this

  saveModel: (e) ->
    @model.set
      first_name: @$('.user-first-name').val()
      last_name: @$('.user-last-name').val()
      username: @$('.user-username').val()
    Backbone.history.navigate('/', trigger: true)
    false
