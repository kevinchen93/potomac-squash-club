class App.Views.CourtReservations extends Backbone.View

  template: JST['court_reservations/index']
  
  render: ->
    @$el.html(@template(court_number: '1'))
    this
