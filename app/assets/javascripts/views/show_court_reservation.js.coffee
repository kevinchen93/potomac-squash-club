class App.Views.ShowCourtReservation extends Backbone.View

  template: JST['court_reservations/show']

  render: ->
    @$el.html(@template(court_reservation: @model))
    this
