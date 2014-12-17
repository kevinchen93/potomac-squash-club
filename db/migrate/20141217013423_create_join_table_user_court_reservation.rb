class CreateJoinTableUserCourtReservation < ActiveRecord::Migration
  def change
    create_join_table :users, :court_reservations do |t|
      # t.index [:user_id, :court_reservation_id]
      # t.index [:court_reservation_id, :user_id]
    end
  end
end
