package com.janas.rewardssimulator.business.commands.control;

import java.util.StringTokenizer;

public enum CallCommand {
	REGISTER {
		@Override
		public void perform(StringTokenizer stringTokenizer) {
			RegisterCommand.perform(stringTokenizer);
		}
	},
	LOAD {
		@Override
		public void perform(StringTokenizer stringTokenizer) {
			LoadCommand.perform(stringTokenizer);
		}
	},
	LEVEL {
		@Override
		public void perform(StringTokenizer stringTokenizer) {
			LevelCommand.perform(stringTokenizer);
		}
	},
	REWARDS {
		@Override
		public void perform(StringTokenizer stringTokenizer) {
			RewardsCommand.perform(stringTokenizer);
		}
	};

	public abstract void perform(StringTokenizer stringTokenizer);
}
