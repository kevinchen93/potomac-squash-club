class App.Routers.PotomacSquashClubRouter extends Backbone.Router
  routes:
    '': 'showCourtReservations'
    'reserve': 'showCourtReservations'
    'court_reservations/:id': 'showCourtReservation'
    'users/:id': 'showUser'

  showUser: (id) ->
    alert("You requested the user with id #{id}")

  showCourtReservation: (id) ->
    alert('router#showCourtReservation')
    model = App.AllCourtReservations[id - 1]
    view = new App.Views.ShowCourtReservation(model: model)
    $('#container').html(view.render().el)

  showCourtReservations: ->
    alert("You requested the court reservations page")
    view = new App.Views.CourtReservations(collection: App.AllCourtReservations)
    $('#container').html(view.render().el)

end
