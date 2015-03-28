class SessionsController < ApplicationController
  def login
    username = params[:username] || params[:session][:username]
    password = params[:password] || params[:session][:password]
    @user = User.find_by(username: username)
    if @user
      flash[:notice] = "Welcome, #{@user}!"
      redirect_to(reserve_path) and return
    else
      flash[:notice] = "No user exists with name: #{username}."
      redirect_to(root_path)
    end
  end
end
