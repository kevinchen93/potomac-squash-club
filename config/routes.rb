Rails.application.routes.draw do

  root 'court_reservations#index'

  resources :court_reservations, only: [:index, :show]
  resources :users, only: [:show, :index, :edit]

  # everything else goes home
  get'*any' => 'court_reservations#index'

end
