package com.janas.rewardssimulator.business.interaction.control;

import java.util.StringTokenizer;

import com.janas.rewardssimulator.business.partners.control.LevelCommand;
import com.janas.rewardssimulator.business.partners.control.RegisterCommand;
import com.janas.rewardssimulator.business.partners.control.RewardsCommand;
import com.janas.rewardssimulator.business.sales.control.LoadCommand;
import com.janas.rewardssimulator.business.sales.control.SellCommand;

public enum CallCommand {
	REGISTER {
		@Override
		public void perform(StringTokenizer command) {
			RegisterCommand.perform(command);
		}
	},
	LOAD {
		@Override
		public void perform(StringTokenizer command) {
			LoadCommand.perform(command);
		}
	},
	LEVEL {
		@Override
		public void perform(StringTokenizer command) {
			LevelCommand.perform(command);
		}
	},
	REWARDS {
		@Override
		public void perform(StringTokenizer command) {
			RewardsCommand.perform(command);
		}
	},
	SELL {
		@Override
		public void perform(StringTokenizer command) {
			SellCommand.perform(command);
		}
	};

	public abstract void perform(StringTokenizer command);
}
