class App.Views.CourtReservations extends Backbone.View

  template: JST['court_reservations/index']

  events:
    'click a': 'showCourtReservation'
  
  render: ->
    @$el.html(@template(court_reservations: @collection))
    this

  showCourtReservation: (e) ->
    alert 'showCourtReservation' 
    $this = $(e.currentTarget)
    url = $this.attr("href")
    Backbone.history.navigate(url, trigger: true)
    false # return false so we don't perform default behavior
