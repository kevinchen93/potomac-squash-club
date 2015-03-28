class CreateCourtReservations < ActiveRecord::Migration
  def change
    create_table :court_reservations do |t|
      t.integer :court_number
      t.datetime :start_time
      t.integer :duration_minutes

      t.timestamps null: false
    end
  end
end
