class SessionsController < ApplicationController
  def login
    puts "PARAMS #{params.inspect}"
    @user = User.find_by(name: params[:session][:name])
    if @user
      redirect_to(reserve_path) and return
    else
      redirect_to(root_path)
    end
  end
end
