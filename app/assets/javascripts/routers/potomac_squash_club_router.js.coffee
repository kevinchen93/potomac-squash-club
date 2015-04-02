class App.Routers.PotomacSquashClubRouter extends Backbone.Router
  routes:
    '': 'showCourtReservations'
    'reserve': 'showCourtReservations'
    'users/:id': 'showUser'

  showUser: (id) ->
    alert("You requested the user with id #{id}")

  showCourtReservations: ->
    alert("You requested the court reservations page")
    view = new App.Views.CourtReservations(collection: App.AllCourtReservations)
    $('#container').html(view.render().el)

end
