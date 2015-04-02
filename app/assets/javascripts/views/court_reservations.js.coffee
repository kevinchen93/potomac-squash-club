class App.Views.CourtReservations extends Backbone.View

  template: JST['court_reservations/index']

  events:
    'click a': 'showCourtReservation'
  
  render: ->
    @$el.html(@template())
    @collection.forEach(@renderCourtReservation)
    this

  renderCourtReservation: (courtReservation) =>
    view = new App.Views.ShowNote(model: courtReservation)
    @$('.court-reservations').append(view.render().el)

  showCourtReservation: (e) ->
    alert 'showCourtReservation' 
    $this = $(e.currentTarget)
    url = $this.attr("href")
    Backbone.history.navigate(url, trigger: true)
    false # return false so we don't perform default behavior
